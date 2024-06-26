-- 코드를 작성해주세요
SELECT 
    CASE
        WHEN H.ID IS NOT NULL THEN 'A'
        WHEN I.ID IS NOT NULL THEN 'B'
        ELSE 'C'
    END AS GRADE,
    G.ID,
    G.EMAIL
FROM DEVELOPERS G 
    LEFT OUTER JOIN
    (        SELECT A.ID
        FROM DEVELOPERS A, SKILLCODES B, SKILLCODES K
        WHERE A.SKILL_CODE & B.CODE = B.CODE
            AND A.SKILL_CODE & K.CODE = K.CODE
            AND UPPER(B.NAME)='PYTHON' 
            AND UPPER(K.CATEGORY)='FRONT END'
        GROUP BY A.ID
    ) H
    ON G.ID=H.ID
    LEFT OUTER JOIN 
    (
        SELECT C.ID
        FROM DEVELOPERS C, SKILLCODES D
        WHERE C.SKILL_CODE & D.CODE = D.CODE
            AND D.NAME='C#'
        GROUP BY C.ID
    ) I
    ON G.ID=I.ID
    LEFT OUTER JOIN
    (
        SELECT E.ID
        FROM DEVELOPERS E, SKILLCODES F
        WHERE E.SKILL_CODE & F.CODE = F.CODE
            AND UPPER(CATEGORY)='FRONT END'
        GROUP BY E.ID
    ) J
    ON G.ID=J.ID
WHERE H.ID IS NOT NULL
    OR I.ID IS NOT NULL
    OR J.ID IS NOT NULL
ORDER BY GRADE ASC, G.ID ASC
;




    
WITH RECURSIVE CTE_COUNT AS (
    SELECT 1 AS N, ID, PARENT_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT N+1 AS N, B.ID, B.PARENT_ID
    FROM CTE_COUNT A, ECOLI_DATA B
    WHERE A.ID = B.PARENT_ID
)
SELECT COUNT(*) AS COUNT, A.N AS GENERATION
FROM CTE_COUNT A LEFT OUTER JOIN CTE_COUNT B
ON A.ID=B.PARENT_ID
WHERE B.N IS NULL
GROUP BY A.N
ORDER BY GENERATION
;
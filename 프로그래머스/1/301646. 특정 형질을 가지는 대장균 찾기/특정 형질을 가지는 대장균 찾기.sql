-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE NOT SUBSTR(CONV(GENOTYPE, 10, 2), -2, 1) = 1
    AND
    (
        SUBSTR(CONV(GENOTYPE, 10, 2), -1, 1) = 1
        OR
        SUBSTR(CONV(GENOTYPE, 10, 2), -3, 1) = 1
    )
;
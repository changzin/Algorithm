-- 코드를 입력하세요
SELECT MCDP_CD AS 진료과코드, COUNT(MCDP_CD) AS 예약
FROM APPOINTMENT
WHERE TO_CHAR(APNT_YMD, 'MM') = 5
GROUP BY MCDP_CD
ORDER BY 예약, 진료과코드
;
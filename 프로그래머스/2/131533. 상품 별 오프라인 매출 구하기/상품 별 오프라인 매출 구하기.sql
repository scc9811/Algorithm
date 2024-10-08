SELECT P.PRODUCT_CODE, SUM(SALES_AMOUNT) * PRICE as SALES
FROM PRODUCT as P INNER JOIN OFFLINE_SALE as OS ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY OS.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE ASC;


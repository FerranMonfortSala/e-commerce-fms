CREATE TABLE PRICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'identificador en la table AUTO_INCREMENT',
    BRAND_ID BIGINT NOT NULL COMMENT 'foreign key de la cadena del grupo (1 = ZARA).',
    START_DATE TIMESTAMP NOT NULL COMMENT 'rango de fechas en el que aplica el precio tarifa indicado.',
    END_DATE TIMESTAMP NOT NULL COMMENT 'rango de fechas en el que aplica el precio tarifa indicado.',
    PRICE_LIST INT NOT NULL COMMENT 'Identificador de la tarifa de precios aplicable',
    PRODUCT_ID BIGINT NOT NULL COMMENT 'Identificador código de producto',
    PRIORITY INT NOT NULL COMMENT 'Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico)',
    PRICE numeric(38,2) NOT NULL COMMENT 'precio final de venta',
    CURR varchar(255) NOT NULL COMMENT 'iso de la moneda'
);
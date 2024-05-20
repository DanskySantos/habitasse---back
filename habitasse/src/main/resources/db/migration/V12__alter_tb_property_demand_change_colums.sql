-- 1. Adicionar colunas temporárias
ALTER TABLE tb_property_demand ADD COLUMN furnished_temp varchar(255);
ALTER TABLE tb_property_demand ADD COLUMN pet_friendly_temp varchar(255);

-- 2. Copiar dados das colunas booleanas para as colunas temporárias
UPDATE tb_property_demand
SET furnished_temp = CASE
                         WHEN furnished THEN 'YES'
                         ELSE 'NO'
    END,
    pet_friendly_temp = CASE
                            WHEN pet_friendly THEN 'YES'
                            ELSE 'NO'
        END;

-- 3. Remover as colunas booleanas originais
ALTER TABLE tb_property_demand DROP COLUMN furnished;
ALTER TABLE tb_property_demand DROP COLUMN pet_friendly;

-- 4. Renomear as colunas temporárias para os nomes originais
ALTER TABLE tb_property_demand RENAME COLUMN furnished_temp TO furnished;
ALTER TABLE tb_property_demand RENAME COLUMN pet_friendly_temp TO pet_friendly;

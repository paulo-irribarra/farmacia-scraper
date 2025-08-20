-- Farmacias oficiales
CREATE TABLE IF NOT EXISTS pharmacy (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL UNIQUE,
  website TEXT
);

-- Medicamentos normalizados
CREATE TABLE IF NOT EXISTS medication (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  strength TEXT,
  form TEXT,
  unit_count INT,
  atc_code TEXT,
  UNIQUE (name, strength, form, unit_count)
);

-- Catálogo por farmacia
CREATE TABLE IF NOT EXISTS pharmacy_item (
  id SERIAL PRIMARY KEY,
  pharmacy_id INT NOT NULL REFERENCES pharmacy(id),
  medication_id INT NOT NULL REFERENCES medication(id),
  pharmacy_sku TEXT,
  url TEXT,
  UNIQUE (pharmacy_id, medication_id)
);

-- Snapshots de precio
CREATE TABLE IF NOT EXISTS price_snapshot (
  id BIGSERIAL PRIMARY KEY,
  pharmacy_item_id INT NOT NULL REFERENCES pharmacy_item(id),
  price_clp NUMERIC(12,2) NOT NULL,
  in_stock BOOLEAN NOT NULL,
  captured_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Índices
CREATE INDEX IF NOT EXISTS idx_price_item_time ON price_snapshot (pharmacy_item_id, captured_at DESC);
CREATE INDEX IF NOT EXISTS idx_med_name ON medication (name);

-- Semillas (opcionales)
INSERT INTO pharmacy (name, website) VALUES
  ('Cruz Verde','https://www.cruzverde.cl'),
  ('Salcobrand','https://www.salcobrand.cl'),
  ('Ahumada','https://www.farmaciaahumada.cl')
ON CONFLICT (name) DO NOTHING;

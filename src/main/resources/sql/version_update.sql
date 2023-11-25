CREATE SEQUENCE version_sequence START 1;

CREATE OR REPLACE FUNCTION update_version() RETURNS TRIGGER AS $$
BEGIN
  NEW.version := nextval('version_sequence');
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- You need to add a separate one for each table
CREATE TRIGGER increment_version
BEFORE INSERT OR UPDATE ON books
FOR EACH ROW
EXECUTE FUNCTION update_version();

CREATE TRIGGER increment_version
BEFORE INSERT OR UPDATE ON writers
FOR EACH ROW
EXECUTE FUNCTION update_version();

CREATE TRIGGER increment_version
BEFORE INSERT OR UPDATE ON writers
FOR EACH ROW
EXECUTE FUNCTION update_version();
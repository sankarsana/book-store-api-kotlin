INSERT INTO writers (id, name) VALUES (1, 'Прабхупада') ON CONFLICT DO NOTHING;

INSERT INTO books (id, name, short_name, writer_id) VALUES (1, 'Бхагавад-гита', 'БГ', 1) ON CONFLICT DO NOTHING;
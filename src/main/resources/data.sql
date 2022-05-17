INSERT INTO user (`email`, `password`, `name`, `company_Id`, `role`, `created_at`)
VALUES ('admin@piada.com', 'supersecretpassword', 'admin', '1', '1', CURRENT_TIMESTAMP);

INSERT INTO company (`name`, `description`, `role`, `created_at`, `updated_at`)
VALUES ('PIADA PIM', 'The site admins of Piada PIM', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
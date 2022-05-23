INSERT IGNORE INTO company (`id`, `name`, `description`, `role`, `created_at`, `updated_at`)
VALUES (1001, 'PIADA PIM', 'The site admins of Piada PIM', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT IGNORE INTO user (`email`, `password`, `name`, `company_Id`, `role`, `created_at`)
VALUES ('admin@piada.com', 'supersecretpassword', 'admin', 1001, 1, CURRENT_TIMESTAMP);
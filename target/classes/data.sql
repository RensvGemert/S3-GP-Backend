INSERT IGNORE INTO company (`id`, `name`, `description`, `role`, `created_at`, `updated_at`)
VALUES (1, 'PIADA PIM', 'The site admins of Piada PIM', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT IGNORE INTO user (`email`, `password`, `name`, `company_Id`, `role`, `created_at`)
VALUES ('admin@piada.com', 'supersecretpassword', 'admin', 1, 1, CURRENT_TIMESTAMP);

INSERT IGNORE INTO category (`id`, `created_at`, `name`)
VALUES (1, CURRENT_TIMESTAMP, 'Clothing, Shoes & accessories'),
(2, CURRENT_TIMESTAMP, 'Foods & Drinks'),
(3, CURRENT_TIMESTAMP, 'Electronics'),
(4, CURRENT_TIMESTAMP, 'Living & Households'),
(5, CURRENT_TIMESTAMP, 'Gardening & Handywork'),
(6, CURRENT_TIMESTAMP, 'Pets & Animals'),
(7, CURRENT_TIMESTAMP, 'Books, Games & Toys');
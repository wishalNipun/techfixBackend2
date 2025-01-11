-- quotation-service/src/main/resources/data.sql

INSERT INTO Quotation (component_name, supplier_name, price, available_quantity) VALUES
                                                                                     ('CPU', 'SupplierA', 250.0, 100),
                                                                                     ('GPU', 'SupplierB', 500.0, 50),
                                                                                     ('RAM', 'SupplierA', 80.0, 200),
                                                                                     ('Motherboard', 'SupplierC', 150.0, 75);

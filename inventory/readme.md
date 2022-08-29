###RabbitMQ service enabling
Got to rabbitmq installed directory and execute this command in sbin folder ``rabbitmq-plugins enable rabbitmq_management``

Then run this command to start rabbitmq ``rabbitmq-server start``

<hr>

###Vault documentation
Source https://spring.io/guides/gs/accessing-vault/

Vault default url http://127.0.0.1:8200

Run vault
``vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"``

Set vault environment
``set VAULT_ADDR=http://127.0.0.1:8200``

Put data in vault server
``vault kv put secret/inventory-service @inventory-service.json``

Read data from vault
``vault kv get secret/inventory-service``

# DynamoDB Enhanced Quarkus example



### Instructions:
1. Set up a Docker container with DynamoDB:
```shell script
docker run --publish 8000:8000 amazon/dynamodb-local:1.11.477 -jar DynamoDBLocal.jar -sharedDb
```
You can add the ```-inMemory``` flag to run DynamoDB in memory.

2. Create a table using AWS CLI: 
```shell script
aws dynamodb create-table \
    --endpoint-url http://localhost:8000 \
    --table-name Course \
    --attribute-definitions \
        AttributeName=name,AttributeType=S \
        AttributeName=edition,AttributeType=N \
    --key-schema \
        AttributeName=name,KeyType=HASH \
        AttributeName=edition,KeyType=RANGE \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --table-class STANDARD
```

3. Run the Quarkus application:
```shell script
mvn quarkus:dev
```
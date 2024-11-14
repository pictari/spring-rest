package app.pictari.aws;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

// Software pattern promoted by Amazon: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
public class DependencyFactory {
    private DependencyFactory() {}

    public static DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().build();
    }
}

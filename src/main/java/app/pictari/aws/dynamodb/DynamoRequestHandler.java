package app.pictari.aws.dynamodb;

import app.pictari.aws.DependencyFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DynamoRequestHandler {
    private final DynamoDbClient dynamoDbClient;

    public DynamoRequestHandler() {
        dynamoDbClient = DependencyFactory.dynamoDbClient();
    }

    public String getAllRooms(String tableName) {

        ScanRequest tableScanner = ScanRequest.builder().tableName(tableName).build();

        StringBuilder sb = new StringBuilder();

        try {
            List<Map<String,AttributeValue>> returnedItems = dynamoDbClient.scan(tableScanner).items();

            if (returnedItems != null) {
                sb.append("{\"items\":[");
                for(int i = 0; i < returnedItems.size();i++) {
                    sb.append("{");
                    Set<String> keys = returnedItems.get(i).keySet();

                    for (String key1 : keys) {
                        sb.append(String.format("\"%s\":\"%s\",", key1, returnedItems.get(i).get(key1).toString()));
                    }
                    sb.setLength(sb.length() - 1);
                    sb.append("}");
                }
                sb.append("]}");
                return sb.toString();
            } else {
                sb.append("No items found!");
                return sb.toString();
            }
        } catch (DynamoDbException e) {
            return(e.getMessage());
        }
    }

    // https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb-items.html
//    public void getDynamoDBItem(String tableName,String key,String keyVal ) {
//
//        HashMap<String, AttributeValue> keyToGet = new HashMap<String,AttributeValue>();
//
//        keyToGet.put(key, AttributeValue.builder()
//                .s(keyVal).build());
//
//        GetItemRequest request = GetItemRequest.builder()
//                .key(keyToGet)
//                .tableName(tableName)
//                .build();
//
//        try {
//            Map<String,AttributeValue> returnedItem = dynamoDbClient.getItem(request).item();
//
//            if (returnedItem != null) {
//                Set<String> keys = returnedItem.keySet();
//                System.out.println("Amazon DynamoDB table attributes: \n");
//
//                for (String key1 : keys) {
//                    System.out.format("%s: %s\n", key1, returnedItem.get(key1).toString());
//                }
//            } else {
//                System.out.format("No item found with the key %s!\n", key);
//            }
//        } catch (DynamoDbException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
//    }
}

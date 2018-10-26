package com.andisan86.e2etest.utils;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;
import java.util.Map;

public class ElasticsearchHelper {
    private static TransportClient client;

    public static void connectToEs() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (Exception e) {
        }
    }

    public static void createIndex(String indexName) {
        client.admin().indices().prepareCreate(indexName).execute().actionGet();
    }

    public static void createMappingSchoolSmp(String indexName, String indexType) {
        try {
            client.admin().indices().preparePutMapping(indexName)
                    .setType(indexType).setSource(XContentFactory.jsonBuilder().startObject()
                            .startObject(indexType)
                                .startObject("properties")
                                    .startObject("npsn").field("type", "keyword").endObject()
                                    .startObject("jenjang").field("type", "keyword").endObject()
                                    .startObject("nama").field("type", "keyword").endObject()
                                    .startObject("provinsi").field("type", "keyword").endObject()
                                    .startObject("kota").field("type", "keyword").endObject()
                                    .startObject("status").field("type", "keyword").endObject()
                                    .startObject("jm_pes").field("type", "integer").endObject()
                                    .startObject("rata_17").field("type", "double").endObject()
                                    .startObject("rata_16").field("type", "double").endObject()
                                    .startObject("rata_15").field("type", "double").endObject()
                                    .startObject("location").field("type", "geo_point").endObject()
                                .endObject()
                            .endObject()
                    .endObject())
                    .execute().actionGet();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static IndexResponse indexToEs(String indexName, String indexType, Map<String, Object> indexContent) {
        return client.prepareIndex(indexName, indexType)
                .setSource(indexContent)
                .get();
    }

    public static GetResponse getIndex(String indexName, String indexType, String indexId) {
        return client.prepareGet(indexName, indexType, indexId).get();
    }

    public static DeleteResponse deleteIndex(String indexName, String indexType, String indexId) {
        return client.prepareDelete(indexName, indexType, indexId).get();
    }

    public static void closeEsConnection() {
        client.close();
    }
}

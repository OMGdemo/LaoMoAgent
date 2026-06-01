//package com.mojh.aiAgent.config.embedding;
//
//import dev.langchain4j.store.embedding.qdrant.QdrantEmbeddingStore;
//import io.qdrant.client.QdrantClient;
//import io.qdrant.client.QdrantGrpcClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QdrantConfig {
//
//    @Value("${qdrant.host:127.0.0.1}")
//    private String host;
//
//    @Value("${qdrant.port:6334}")
//    private int port;
//
//    @Value("${qdrant.use-tls:false}")
//    private boolean useTls;
//
//    @Value("${qdrant.collection-name:beijing-xiehe-hospital-2026}")
//    private String collectionName;
//
//    @Bean
//    public QdrantClient qdrantClient() {
//        QdrantGrpcClient.Builder grpcClientBuilder =
//                QdrantGrpcClient.newBuilder(host, port, useTls);
//        return new QdrantClient(grpcClientBuilder.build());
//    }
//
//    /**
//     * Qdrant 向量存储 Bean
//     * 用于 RAG 场景下的文档向量化存储与检索
//     */
//    @Bean
//    public QdrantEmbeddingStore qdrantEmbeddingStore() {
//        return QdrantEmbeddingStore.builder()
//                .host(host)
//                .port(port)
//                .useTls(useTls)
//                .collectionName(collectionName)
//                .build();
//    }
//}

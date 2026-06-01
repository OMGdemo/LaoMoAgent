package com.mojh.aiAgent.config.retriever;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ContentRetrieverLaoMo {

    @Value("${rag.file-path}")
    private String filePath;

    @Bean
    public ContentRetriever contentRetriever() {
        // 加载文档
        Document document1 = FileSystemDocumentLoader.loadDocument(filePath + "医院信息.md");
        Document document2 = FileSystemDocumentLoader.loadDocument(filePath + "科室信息.md");
        Document document3 = FileSystemDocumentLoader.loadDocument(filePath + "神经内科.md");
        List<Document> documents = new ArrayList<>(Arrays.asList(document1, document2, document3));

        // 创建向量存储器
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        // 把文档存入到向量存储器中
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);

        // 返回内容检索器实体bean，从嵌入存储（EmbeddingStore）里检索和查询内容相关的信息，在智能体上配置这个bean
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}

package inverted_index.global;

import java.util.List;

public final class KeywordConstant {

    private KeywordConstant() {
    }

    // 인터넷 강의 제목 30개 키워드
    public static List<String> keywords = List.of(
            "Java", "Spring", "Hibernate", "JPA", "Redis",
            "ElasticSearch", "Kafka", "Docker", "Kubernetes", "CI/CD",
            "API", "OAuth", "JWT", "Restful", "Microservices",
            "AWS", "GCP", "Azure", "Linux", "Nginx",
            "MySQL", "PostgreSQL", "MongoDB", "GraphQL", "React",
            "Vue", "Angular", "TypeScript", "Python", "Node.js"
    );

    // 강의자 5명 키워드
    public static List<String> teachers = List.of(
            "김영한", "토비", "백기선", "향로", "제미니"
    );
}

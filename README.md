여러 서비스를 이용하다보면 다음과 같은 필터링 기능을 볼 수 있습니다.

![image](https://github.com/user-attachments/assets/64d10827-74a2-43be-b3b8-cd347a82c075)      

수많은 강의들이 있는데 Spring, MySQL, Node.js, React, SQL과 같은 키워드를 바탕으로 해당되는 강의들을 필터링해서         
보여주는 기능입니다. 또 이러한 기술 검색 필터링 외에도 검색 키워드를 바탕으로 해당 키워드를 제목으로 포함한 강의를 보여주는        
기능도 있을 수 있습니다.

검색 기능 구현을 위해서는 3가지 방법 정도가 생각납니다.

1. RDBMS의 like 키워드 사용
2. RDBMS의 Fulltext index 사용
3. Elasticsearch와 같은 검색 엔진 사용

기술적인 내용은 위와 같지만 이러한 기술은 조금 제쳐두고 조금 더 원리에 집중해서 어떻게 기능을 구현하면 좋을지        
생각해보았습니다. 자세한 내용은 아래 글을 참고해주세요.     

[필터링 검색 기능은 어떻게 구현되는 것일까? (feat. inverted index)](https://320hwany.tistory.com/122)     

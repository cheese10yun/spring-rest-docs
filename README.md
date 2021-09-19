# 패스트 캠퍼스 Spring REST Docs

[패스트 캠퍼스 Spring REST Docs](https://fastcampus.co.kr/dev_online_spring)

## REST Docs Document Build

```
$ cid rest-docs
$ ./gradlew asciidoctor
```

`/build/docs/asciidoc/index.html` 경로에 Document 생성

## Document Publishing

```
$ cid rest-docs
$ ./gradlew bootJar
$ java -jar build/libs/rest-docs-0.0.1-SNAPSHOT.jar 
```

[http://localhost:8383/docs/index.html](http://localhost:8383/docs/index.html) 해당 경로로 REST Docs HTML 문서로 퍼블리싱
# Elasticsearch

## curl 명령어

```
$ curl -X{Method} http://{Host}/{Index}/{Type}/{Id}\?pretty

Method : HTTP 메서드 ex) GET, POST, PUT, DELETE
Host : 호스트 주소 ex) localhost:9200
Index : Elasticsearch index name
Type : Elasticsearch type name
Id : Document id
?pretty : 예쁘게? 출력
```

Index 생성
```
$ curl -XPUT http://localhost:9200/es\?pretty
{
  "acknowledged" : true,
  "shards_acknowledged" : true,
  "index" : "es"
}                                                                                                                    
```

Index 조회
```
$ curl -XGET http://localhost:9200/es\?pretty
{
  "es" : {
    "aliases" : { },
    "mappings" : { },
    "settings" : {
      "index" : {
        "creation_date" : "1574951243805",
        "number_of_shards" : "5",
        "number_of_replicas" : "1",
        "uuid" : "3IDnPiwzTlGFYNRkJs2LjA",
        "version" : {
          "created" : "6080599"
        },
        "provided_name" : "es"
      }
    }
  }
}
```

Document 생성
```
$ curl -XPOST http://localhost:9200/es/account/1\?pretty 
        -H 'Content-Type: application/json' 
        -d '{"id" : 1, "username" : "test1", "email" : "test1@google.com", "enabled" : false}'
{
  "_index" : "es",
  "_type" : "account",
  "_id" : "1",
  "_version" : 3,
  "result" : "created",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "_seq_no" : 2,
  "_primary_term" : 1
}

$ curl -XGET http://localhost:9200/es\?pretty
{
  "es" : {
    "aliases" : { },
    "mappings" : {
      "account" : {
        "properties" : {
          "email" : {
            "type" : "text",
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          },
          "enabled" : {
            "type" : "boolean"
          },
          "id" : {
            "type" : "long"
          },
          "username" : {
            "type" : "text",
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          }
        }
      }
    },
    "settings" : {
      "index" : {
        "creation_date" : "1574951243805",
        "number_of_shards" : "5",
        "number_of_replicas" : "1",
        "uuid" : "3IDnPiwzTlGFYNRkJs2LjA",
        "version" : {
          "created" : "6080599"
        },
        "provided_name" : "es"
      }
    }
  }
}
```

Document 조회
```
$ curl -XGET http://localhost:9200/es/account/1\?pretty
{
  "_index" : "es",
  "_type" : "account",
  "_id" : "1",
  "_version" : 3,
  "_seq_no" : 2,
  "_primary_term" : 1,
  "found" : true,
  "_source" : {
    "id" : 1,
    "username" : "test1",
    "email" : "test1@google.com",
    "enabled" : false
  }
}
```

Document 수정
```
$ curl -XPOST http://localhost:9200/es/account/1\?pretty 
        -H 'Content-Type: application/json' 
        -d '{"id" : 1, "username" : "test3", "email" : "test3@google.com", "enabled" : false}'
{
  "_index" : "es",
  "_type" : "account",
  "_id" : "1",
  "_version" : 4,
  "result" : "updated",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "_seq_no" : 3,
  "_primary_term" : 1
}
```

Document 삭제
```
$ curl -XDELETE http://localhost:9200/es/account/1\?pretty
{
  "_index" : "es",
  "_type" : "account",
  "_id" : "1",
  "_version" : 5,
  "result" : "deleted",
  "_shards" : {
    "total" : 2,
    "successful" : 1,
    "failed" : 0
  },
  "_seq_no" : 4,
  "_primary_term" : 1
}

$ curl -XGET http://localhost:9200/es/account/1\?pretty
{
  "_index" : "es",
  "_type" : "account",
  "_id" : "1",
  "found" : false
}
```

Index 삭제
```
$ curl -XDELETE http://localhost:9200/es\?pretty
{
  "acknowledged" : true
}

$ curl -XGET http://localhost:9200/es\?pretty
{
  "error" : {
    "root_cause" : [
      {
        "type" : "index_not_found_exception",
        "reason" : "no such index",
        "resource.type" : "index_or_alias",
        "resource.id" : "es",
        "index_uuid" : "_na_",
        "index" : "es"
      }
    ],
    "type" : "index_not_found_exception",
    "reason" : "no such index",
    "resource.type" : "index_or_alias",
    "resource.id" : "es",
    "index_uuid" : "_na_",
    "index" : "es"
  },
  "status" : 404
}
```

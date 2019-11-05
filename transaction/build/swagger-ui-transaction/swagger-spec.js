window.swaggerSpec={
  "openapi" : "3.0.0",
  "info" : {
    "title" : "Transaction API",
    "description" : "Transaction API for banking microservices",
    "version" : "1.0.0"
  },
  "paths" : {
    "/transaction" : {
      "post" : {
        "summary" : "Make transaction between account",
        "tags" : [ "POST" ],
        "operationId" : "makeTransaction",
        "requestBody" : {
          "required" : true,
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/TransactionInput"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Accepted for processing"
          }
        }
      },
      "get" : {
        "summary" : "Get status of all transactions within 24 hours",
        "tags" : [ "GET" ],
        "operationId" : "getAllTransactions",
        "responses" : {
          "200" : {
            "$ref" : "#/components/responses/OkTransaction"
          }
        }
      }
    },
    "/sender/{id}/transaction" : {
      "get" : {
        "summary" : "Get status of all transaction by sender account Id",
        "tags" : [ "GET" ],
        "operationId" : "transactionBySenderAccountId",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "description" : "Sender account Id",
          "schema" : {
            "type" : "string",
            "format" : "uuid"
          }
        } ],
        "responses" : {
          "200" : {
            "$ref" : "#/components/responses/OkTransaction"
          }
        }
      }
    },
    "/recipient/{id}/transaction" : {
      "get" : {
        "summary" : "Get status of all transaction by recipient account Id",
        "tags" : [ "GET" ],
        "operationId" : "transactionByRecipientAccountId",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "description" : "Recipient account Id",
          "schema" : {
            "type" : "string",
            "format" : "uuid"
          }
        } ],
        "responses" : {
          "200" : {
            "$ref" : "#/components/responses/OkTransaction"
          }
        }
      }
    }
  },
  "components" : {
    "responses" : {
      "OkTransaction" : {
        "description" : "Ok",
        "content" : {
          "application/json" : {
            "schema" : {
              "$ref" : "#/components/schemas/TransactionOutput"
            }
          }
        }
      }
    },
    "schemas" : {
      "TransactionInput" : {
        "type" : "object",
        "properties" : {
          "senderAccountId" : {
            "type" : "string"
          },
          "recipientAccountId" : {
            "type" : "string"
          },
          "amount" : {
            "type" : "integer"
          }
        },
        "required" : [ "senderAccountId", "recipientAccountId", "amount" ]
      },
      "TransactionOutput" : {
        "type" : "object",
        "allOf" : [ {
          "$ref" : "#/components/schemas/TransactionInput"
        }, {
          "type" : "object",
          "properties" : {
            "time" : {
              "type" : "string",
              "format" : "datetime"
            },
            "status" : {
              "type" : "string",
              "enum" : [ "Pending", "Accepted", "Rejected" ]
            }
          }
        } ]
      }
    }
  }
}
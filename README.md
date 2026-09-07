# Spring AI demo

A small Spring Boot application that exposes a single chat endpoint backed by
Spring AI and OpenAI. It is deliberately minimal so it can be used as a
starting point for demos and experiments.

## Prerequisites

* Java 21+
* An OpenAI API key

## Run it

```bash
export OPENAI_API_KEY="your-api-key"
mvn spring-boot:run
```

Then send a prompt:

```bash
curl -X POST http://localhost:8080/api/chat \
  -H 'Content-Type: application/json' \
  -d '{"message":"Explain Spring AI in one sentence."}'
```

The endpoint returns JSON containing the model response. The API key is read
from `OPENAI_API_KEY`; do not add keys to source control.

## Test

```bash
mvn test
```

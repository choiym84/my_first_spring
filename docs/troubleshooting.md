# Troubleshooting

Use this file to record problems, causes, fixes, and lessons learned.

## Template

```md
## Problem

What happened?

## Cause

Why did it happen?

## Fix

How was it solved?

## Lesson

What should be remembered next time?
```

## H2 Console Returned 404

## Problem

`/h2-console` returned a Whitelabel 404 page.

## Cause

Spring Boot 4 requires the H2 console module to be on the classpath.

## Fix

Added:

```gradle
runtimeOnly 'org.springframework.boot:spring-boot-h2console'
```

## Lesson

H2 driver and H2 console support are separate concerns.

## JPA Persist Failed Without Transaction

## Problem

Calling `EntityManager.persist()` failed with:

```text
No EntityManager with actual transaction available
```

## Cause

JPA write operations require an active transaction.

## Fix

Added `@Transactional` to the service method or service class.

## Lesson

Transaction boundaries usually belong in the service layer.

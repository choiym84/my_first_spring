# Spring Study Learning Log

## Project Goal
- Learn Spring Boot from the beginning with Java 17 and IntelliJ.
- Build a small member management app step by step.

## Progress So Far

### 1. Spring Boot setup
- Created a Spring Boot project with Gradle and Java 17.
- Ran the application and confirmed `localhost:8080`.

### 2. Basic controller
- Added `HelloController`.
- Practiced `@GetMapping`, `@ResponseBody`, and simple string responses.

### 3. Thymeleaf template rendering
- Created template-based responses.
- Learned the difference between returning a string body and returning a view name.

### 4. Request parameters and Model
- Implemented `/hello-mvc`.
- Learned `@RequestParam`, `Model`, and `th:text`.

### 5. Form submission
- Built an HTML form and submitted data with `GET` and `POST`.
- Learned why `input name` is important.

### 6. Service layer
- Separated controller logic from service logic.
- Added `HelloService`.
- Learned constructor injection and dependency injection.

### 7. Domain and repository
- Added `Member` domain object.
- Added `MemoryMemberRepository`.
- Implemented save, findAll, findByName.

### 8. Tests
- Wrote repository tests.
- Wrote service tests.
- Practiced `assertEquals`, `assertThrows`, `contains`, and test case design.

### 9. Member web flow
- Added `MemberController`.
- Built member registration form and member list page.
- Connected controller -> service -> repository.

### 10. DTO/Form object
- Added `MemberForm`.
- Used form object binding instead of only `@RequestParam`.
- Learned how Spring binds request data to an object.

### 11. Error handling
- Added duplicate member validation.
- Added blank name validation.
- Caught service exceptions in the controller.
- Displayed error messages in the form page.

### 12. PRG and form value retention
- Used redirect after successful POST.
- Kept form input value on validation failure with `memberForm`.

### 13. Package structure
- Moved classes into role-based packages:
  - `controller`
  - `service`
  - `repository`
  - `domain`

### 14. H2 and JPA setup
- Added H2 database dependency and H2 console support.
- Added Spring Data JPA dependency.
- Configured an in-memory H2 database.
- Learned that H2 console access and application DB usage are different concerns.

### 15. JPA entity and repository
- Converted `Member` into a JPA entity.
- Created `JpaMemberRepository` using `EntityManager`.
- Learned `persist()`, JPQL, and transaction boundaries.
- Added `@Transactional` to the service layer.

### 16. Repository interface
- Added `MemberRepository` interface.
- Made memory and JPA repositories implement the same interface.
- Changed `MemberService` to depend on `MemberRepository`.
- Learned why multiple implementations require `@Primary`, `@Qualifier`, or explicit configuration.

### 17. Spring Data JPA
- Added `SpringDataJpaMemberRepository`.
- Learned that `JpaRepository` provides common methods such as `save()` and `findAll()`.
- Learned that custom finder methods such as `findByName()` can be created from method names.

### 18. Board domain start
- Added `Post` entity.
- Added fields for title, content, writer, and created time.
- Started board feature development.

## Current Structure
- `controller/HelloController.java`
- `controller/MemberController.java`
- `controller/MemberForm.java`
- `domain/Member.java`
- `repository/MemoryMemberRepository.java`
- `repository/JpaMemberRepository.java`
- `repository/MemberRepository.java`
- `repository/SpringDataJpaMemberRepository.java`
- `domain/Post.java`
- `service/HelloService.java`
- `service/MemberService.java`
- templates:
  - `form.html`
  - `members.html`
  - `hello.html`
  - `hello-mvc.html`
  - `service.html`

## What Works Now
- `GET /member/new` shows the member registration form.
- `POST /member/new` registers a member.
- Success redirects to `GET /member/members`.
- Duplicate name and blank name are handled as errors.
- Error messages are shown in the form page.
- `GET /member/members` shows the member list.
- Member data is now intended to be persisted through JPA/H2 instead of only memory storage.
- Board domain work has started with the `Post` entity.

## Key Concepts Learned
- Spring Boot app startup
- Controller / Service / Repository separation
- Dependency Injection
- Thymeleaf basics
- Request parameter binding
- Form DTO (`MemberForm`)
- Exception handling in web flow
- PRG pattern
- Basic testing
- H2 database
- JPA entity mapping
- EntityManager
- Transaction boundaries
- Repository interface design
- Spring Data JPA

## Notes
- The member feature has moved from memory storage toward JPA/H2 persistence.
- The next major topic is building the board CRUD feature.

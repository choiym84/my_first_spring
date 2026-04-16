# [Step 22] Create PostService

## Goal

게시글 작성과 조회를 담당하는 서비스 계층을 만든다.

## Tasks

- [ ] `PostService` 클래스 생성
- [ ] `PostRepository` 생성자 주입
- [ ] `write(Post post)` 메서드 추가
- [ ] `findPosts()` 메서드 추가
- [ ] 제목/내용/작성자 빈 값 검증

## Acceptance Criteria

- [ ] 게시글 저장 로직이 서비스에 있다.
- [ ] 게시글 목록은 최신순으로 조회된다.
- [ ] 빈 제목/내용/작성자는 저장되지 않는다.
- [ ] 쓰기 작업은 트랜잭션 안에서 실행된다.

## Notes

- 게시글의 비즈니스 규칙은 컨트롤러가 아니라 서비스에 둔다.
- 조회 메서드는 `@Transactional(readOnly = true)` 를 고려한다.

## Troubleshooting

- 

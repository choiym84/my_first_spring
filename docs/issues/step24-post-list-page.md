# [Step 24] Create Post List Page

## Goal

게시글 목록 화면을 만든다.

## Tasks

- [ ] `GET /posts` 구현
- [ ] `postList.html` 생성
- [ ] 게시글 목록을 `Model` 에 담기
- [ ] Thymeleaf `th:each` 로 목록 출력
- [ ] 최신 글이 위에 오도록 정렬

## Acceptance Criteria

- [ ] `/posts` 에서 게시글 목록이 보인다.
- [ ] 각 게시글의 id, title, writer, createdAt 이 보인다.
- [ ] 최신 게시글이 먼저 보인다.

## Notes

- `PostRepository.findAllByOrderByCreatedAtDesc()` 를 사용한다.

## Troubleshooting

- 

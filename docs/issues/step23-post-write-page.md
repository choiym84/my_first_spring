# [Step 23] Create Post Write Page

## Goal

게시글 작성 화면과 작성 요청 처리를 만든다.

## Tasks

- [ ] `PostController` 생성
- [ ] `PostForm` 생성
- [ ] `GET /posts/new` 구현
- [ ] `POST /posts/new` 구현
- [ ] `postForm.html` 생성
- [ ] 작성 성공 시 `/posts` 로 redirect
- [ ] 작성 실패 시 에러 메시지와 입력값 유지

## Acceptance Criteria

- [ ] 브라우저에서 게시글 작성 폼을 볼 수 있다.
- [ ] 폼 제출 시 게시글이 저장된다.
- [ ] 성공 후 PRG 패턴으로 목록 페이지로 이동한다.
- [ ] 검증 실패 시 작성 화면으로 돌아오고 에러 메시지가 보인다.

## Notes

- 회원 등록 폼 흐름을 참고한다.
- `PostForm` 은 화면 입력용 DTO다.

## Troubleshooting

- 

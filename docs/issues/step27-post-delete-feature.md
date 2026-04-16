# [Step 27] Add Post Delete Feature

## Goal

게시글 삭제 기능을 만든다.

## Tasks

- [ ] `POST /posts/{id}/delete` 구현
- [ ] `PostService.deletePost(id)` 구현
- [ ] 상세 화면 또는 목록 화면에 삭제 버튼 추가
- [ ] 삭제 후 `/posts` 로 redirect

## Acceptance Criteria

- [ ] 게시글을 삭제할 수 있다.
- [ ] 삭제 후 목록 페이지로 이동한다.
- [ ] 삭제된 게시글은 목록과 상세 조회에서 보이지 않는다.

## Notes

- 삭제는 데이터 변경이므로 GET이 아니라 POST로 처리한다.

## Troubleshooting

- 

# [Step 26] Add Post Edit Feature

## Goal

게시글 수정 기능을 만든다.

## Tasks

- [ ] `Post` 에 `update(title, content)` 메서드 추가
- [ ] `GET /posts/{id}/edit` 구현
- [ ] `POST /posts/{id}/edit` 구현
- [ ] `postEditForm.html` 생성
- [ ] 기존 제목/내용을 수정 폼에 표시
- [ ] 수정 후 상세 페이지 또는 목록 페이지로 redirect

## Acceptance Criteria

- [ ] 기존 게시글을 수정할 수 있다.
- [ ] setter 대신 의미 있는 `update()` 메서드로 변경한다.
- [ ] 빈 제목/내용은 수정되지 않는다.
- [ ] JPA 변경 감지로 update가 반영된다.

## Notes

- 트랜잭션 안에서 엔티티를 조회하고 값을 바꾸면 JPA가 변경 감지로 UPDATE SQL을 만든다.

## Troubleshooting

- 

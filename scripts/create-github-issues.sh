#!/usr/bin/env bash
set -euo pipefail

if ! command -v gh >/dev/null 2>&1; then
  echo "GitHub CLI 'gh' is not installed."
  echo "Install it first, then run this script again."
  echo "macOS example: brew install gh"
  exit 1
fi

if ! gh auth status >/dev/null 2>&1; then
  echo "GitHub CLI is not authenticated."
  echo "Run: gh auth login"
  exit 1
fi

create_issue() {
  local title="$1"
  local file="$2"

  echo "Creating issue: ${title}"
  gh issue create \
    --title "${title}" \
    --body-file "${file}" \
    --label "learning"
}

create_issue "[Step 22] Create PostService" "docs/issues/step22-post-service.md"
create_issue "[Step 23] Create Post Write Page" "docs/issues/step23-post-write-page.md"
create_issue "[Step 24] Create Post List Page" "docs/issues/step24-post-list-page.md"
create_issue "[Step 25] Create Post Detail Page" "docs/issues/step25-post-detail-page.md"
create_issue "[Step 26] Add Post Edit Feature" "docs/issues/step26-post-edit-feature.md"
create_issue "[Step 27] Add Post Delete Feature" "docs/issues/step27-post-delete-feature.md"

echo "Done."

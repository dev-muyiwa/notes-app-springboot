```toml
name = 'updateNoteById'
description = '/api/notes/{id}'
method = 'POST'
url = '{{baseUrl}}/api/notes/{id}'
sortWeight = 4000000
id = 'ddba4d0d-6007-4d18-9f33-01145c0c1697'

[[pathVariables]]
key = 'id'

[body]
type = 'JSON'
raw = '''
{
  "id": null,
  "title": "",
  "content": "",
  "createdAt": "2024-09-14",
  "updatedAt": "2024-09-14"
}'''
```

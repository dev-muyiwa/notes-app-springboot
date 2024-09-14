```toml
name = 'updateNoteById'
description = '/api/notes/{id}'
method = 'POST'
url = '{{baseUrl}}/api/notes/{id}'
sortWeight = 4000000
id = 'ddba4d0d-6007-4d18-9f33-01145c0c1697'

[[pathVariables]]
key = 'id'
value = 'f4c86c3a-3f69-48aa-8e53-1110ba17d101'

[body]
type = 'JSON'
raw = '''
{
  "title": "API 201",
}'''
```

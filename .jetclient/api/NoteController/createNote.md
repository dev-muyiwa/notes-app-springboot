```toml
name = 'createNote'
description = '/api/notes'
method = 'POST'
url = '{{baseUrl}}/api/notes'
sortWeight = 1000000
id = '9bb38ca1-bc98-4a16-bb28-6095253758d1'

[body]
type = 'JSON'
raw = '''
{
  "title": "API Note",
  "content": "This is a note created using the REST API."
}'''
```

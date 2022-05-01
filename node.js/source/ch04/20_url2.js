var url = require('url');

var x = url.format({
    protocol: 'https',
    hostname: 'example.com',
    pathname: '/some/path',
    query: {
        page: 1,
        format: 'json'
    }
});

// https://example.com/some/path?page=1&format=json
console.log(x.toString());


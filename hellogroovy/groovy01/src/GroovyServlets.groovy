/**
 * Created by shliangyan on 2017/4/20.
 */
println """
<html>
<head>
    <title>Hello World groovlet</title>
    <link rel="stylesheet" href="groovy.css" type="text/css">
</head>
<body>
    <p class="redarial20">Hello world groovlet</p>
</body>
</html>
"""

import groovy.xml.MarkupBuilder
html.html(){
    head(){
        title("Hello system groovlet")
    }
}
        
<%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/3/10
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register page</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
<style>
    .m-container-small{
        max-width: 60em !important;
        margin: auto;
    }
    .m-padded-tb-massive{
        padding-top: 5em !important;
        padding-bottom: 5em !important;
    }
</style>
<body>

<br>
<br>
<br>
<div class="m-container-small m-padded-tb-massive" style="width:30em !important;">
    <div class="ui container">
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <h2 class="ui teal image header">
                    <div class="content">
                        New User Registration!
                    </div>
                </h2>
                <form class="ui large form" method="post" action="${pageContext.request.contextPath}/register" >
                    <div class="ui stacked segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="username" placeholder="username">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" id="password" name="password" placeholder="password">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="envelope icon"></i>
                                <input type="eamil" name="email" placeholder="email">
                            </div>
                        </div>
                        <div class="inline fields">
                            <label> Gender</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="Gender" checked="checked" value="1" tabindex="0" class="hidden">
                                    <label>Male</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="Gender" value="0" tabindex="0" class="hidden">
                                    <label>Female</label>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="calendar check icon"></i>
                                <input type="date" name="birth">
                            </div>
                        </div>
                        <button class="ui fluid large teal submit button">register</button>
                    </div>

                    <div class="ui error mini message"></div>

                </form>
            </div>
        </div>
    </div>
</div>

<script src="static/js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<script>
    $('.ui.radio.checkbox').checkbox();
    $('.ui.form').form({
        fields : {
            username : {
                identifier: 'username',
                rules: [{
                    type : 'empty',
                    prompt: 'please input username!'
                }]
            },
            password : {
                identifier: 'password',
                rules: [{
                    type   : 'empty',
                    prompt : 'Please enter your password'
                },
                    {
                        type   : 'length[8]',
                        prompt : 'Your password must be at least 8 characters'
                    }]
            },
            email : {
                identifier: 'email',
                rules: [{
                    type : 'email',
                    prompt: 'please input correct email!'
                }]
            },
            birth : {
                identifier: 'birth',
                rules: [{
                    type : 'empty',
                    prompt: 'please input date!'
                }]
            },
        }
    });
</script>

</body>
</html>

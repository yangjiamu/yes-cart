<!DOCTYPE html>
<html lang="en">
<head>
  <base href="<%= APP_BASE %>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title><%= APP_TITLE %></title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- inject:css -->
  <!-- endinject -->
</head>
<body>

  <sd-app>Loading...</sd-app>

  <script>
  // Fixes undefined module function in SystemJS bundle
  function module() {}
  </script>

  <!-- shims:js -->
  <!-- endinject -->

  <% if (BUILD_TYPE === 'dev') { %>
  <script src="<%= APP_BASE %>app/system-config.js"></script>
  <% } %>

  <!-- libs:js -->
  <!-- endinject -->

  <!-- inject:js -->
  <!-- endinject -->

  <% if (BUILD_TYPE === 'dev') { %>
  <script>
  System.import('<%= BOOTSTRAP_MODULE %>')
    .catch(function (e) {
      console.error(e,
        'Report this error at http://www.inspire-software.com/jira/browse/YC');
    });
  </script>
  <% } %>

</body>
</html>

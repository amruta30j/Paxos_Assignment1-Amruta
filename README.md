# Paxos_Assignment1-Amruta
Publishing a small webservice

Additional questions

What would the bottleneck(s) be in your implementation as you acquire more users? How you might scale your
microservice?

This application can be better taken cared by using multithreading. Being a small scale application it is easily managed by
using thread-per-task approach. However, as the complexity of the application grows it may encounter thread creation and teardown costs.
Moreover, thread suspension and resumption would create a performance issue. Moreover if the thread count threashold is reached,it may
result in an out-of-memory error.
The better approach would be to with executors framework as it is considered as most powerful and flexible task execution framework.


In oreder to make this application more scalable, spring boot framework is highly recommended.



How did you deploy the application and why did you choose to deploy it this way? How would you improve
this deployment process if you needed to maintain it long term?

At present, I have deployed this application inside a tomcat server(this is the tomcat embedded in the intellij editor)

The better approach would be to use docker to run tomcat server and run your java web application.



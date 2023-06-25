# gitstafette-explorer

Java demo application (testing spring boot 3, spring 6) for exploring the state of a gitstafette server / client

## Goal

* learn to use new language features
* learn to use Spring Boot 3, Spring 6
* learn to use Gradle with Kotlin
* learn to use kubernetes related integrations (such as Vault)
* provide backend for insight into a **Gitstafette Relay Cluster**
  * a **Gitstafette Relay Cluster** being one or more servers with one or more clients
  * GUI should be something like NextJS or React

## TODO

* Query status of a **Gitstafette Server**
  * query One server
  * clients currently have no status endpoints
    * Gitstafette Client should have a REST or GraphQL endpoint
* provide basic REST API
* Query status of a **Gitstafette Server**
  * query more than one server
  * store results in database
  * Support mTLS
* provide GraphQL API
* Query status of a **Gitstafette Client**

## References

* https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#running-your-application
* https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/htmlsingle/
* https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#using.devtools
* https://spring.io/guides/tutorials/rest/
* https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/
* https://www.baeldung.com/spring-native-intro
* https://github.com/diffplug/spotless/tree/main/plugin-maven#quickstart
* https://engineering.fb.com/2022/11/22/developer-tools/meta-java-nullsafe/
* https://spring.io/blog/2022/10/12/observability-with-spring-boot-3?s=31
* https://developer.okta.com/blog/2022/06/17/simple-crud-react-and-spring-boot
* https://snyk.io/blog/create-sboms-java-maven-gradle/
* https://javatodev.com/hashicorp-vault-spring-boot/
* WSL2 and filesystem: https://stackoverflow.com/questions/68972448/why-is-wsl-extremely-slow-when-compared-with-native-windows-npm-yarn-processing
* WSL2 and linux filesystem location: https://superuser.com/questions/1642403/wsl-for-linux-where-are-files-stored
  * `cd ~` (in WSL2 ubuntu)
  * `cd \\wsl.localhost\Ubuntu-CommPrev\home\joostvdg\projects\`

(defproject dash "0.1.0"
  :description "Some useful functions"
  :url "https://github.com/gfZeng/java-dash"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :deploy-repositories [["releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                                     :creds :gpg}
                         "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                                      :creds :gpg}]]
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :scm {:url "https://github.com/gfZeng/java-dash"}
  :pom-addition [:developers [:developer
                              [:name "Isaac Tsang"]
                              [:url "https://github.com/gfZeng/java-dash"]
                              [:timezone "+8"]]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"])

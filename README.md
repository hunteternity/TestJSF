專案採用H2 DB memory模式 執行專案前須將以下設定加入 server的context.xml檔中 
`<Resource auth="Container" driverClassName="org.h2.Driver" maxActive="10" maxIdle="10" maxWait="10" name="jdbc/testdb" password="" type="javax.sql.DataSource" url="jdbc:h2:mem:testdb;INIT=runscript from \'classpath:scripts/jamari.sql\';LOCK_MODE=1;MVCC=TRUE;DB_CLOSE_DELAY=-1;MODE=Oracle" username="sa"/>`

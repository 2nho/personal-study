const cluster = require("cluster");

// SCHED_RR : Round Robin 방식으로 세팅
// SCHED_NONE : OS 설정에 맡김
cluster.schedulingPolicy = cluster.SCHED_RR;

// cluster.isMaster : 마스터 클러스터인지 확인
// cluster.isWorker : 워커 클러스터인지 확인
if(cluster.isMaster == true){

    // 3개의 작업을 병렬처리 함
    cluster.fork();
    cluster.fork();
    cluster.fork();

    cluster.on("online", function(worker){
        setInterval(() => {
            console.log(worker.process.pid, "동작");    
        }, 1000);
    });
}



# recipeApp
this is spring boot application with in memory H2 database
integrating with jenkins and sonar qube


1) running sonar goal

mvn sonar:sonar

2) creating docker image and push to repo
docker tag b2876a355f28 akshayp07/samplerepo
docker push akshayp07/samplerepo

3) docker system prune -a - deletes all container
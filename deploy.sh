# Add Project path /workspace/bizleap-hr or /workspace/bizleap-snd-application
export PROJECTROOT_DIR=/d/bizleap-training-project/training-project/bizleap-ds
export PROJECTCOMMON_DIR=/d/bizleap-training-project/training-project/bizleap-commons
# Add Project name - bizleap-hr-application or bizleap-snd-application
export WEBPROJECT_NAME=bizleap-ds-application

# Add Tomcat path - 
export TOMCAT_ROOT=/d/bizleap-apache-tomcat-8.0.33

# Add BackUp Path
# UNCOMMENT this block to store war with comments
#export BACKUP_PATH=/Users/kaung/Documents/WORK/backup
#export TENANT_ID=$1

export TARGET_DIR=$PROJECTROOT_DIR/$WEBPROJECT_NAME/target

export DEPLOY_DIR=$TOMCAT_ROOT/webapps

echo
echo ">>>>>>>>>>>>>>>>>>>> Shutting down Tomcat Server <<<<<<<<<<<<<<<<<<<<"
$TOMCAT_ROOT/bin/shutdown.sh

echo
echo ">>>>>>>>>>>>>>>>>>>> Building Application <<<<<<<<<<<<<<<<<<<<"
cd $PROJECTCOMMON_DIR
mvn clean install -Dmaven.test.skip=true

cd $PROJECTROOT_DIR
mvn clean install -Dmaven.test.skip=true

echo ">>>>>>>>>>>>>>>>>>>> Finish Building Application <<<<<<<<<<<<<<<<<<<<"

echo
echo ">>>>>>>>>>>>>>>>>>>> Removing the old war file and dir <<<<<<<<<<<<<<<<<<<<"
rm $DEPLOY_DIR/$WEBPROJECT_NAME.war
rm -r $DEPLOY_DIR/$WEBPROJECT_NAME

echo
echo ">>>>>>>>>>>>>>>>>>>> Copying war to Tomcat/webapp <<<<<<<<<<<<<<<<<<<<"
cp $TARGET_DIR/$WEBPROJECT_NAME.war $DEPLOY_DIR/$WEBPROJECT_NAME.war

echo
echo ">>>>>>>>>>>>>>>>>>>> Starting Tomcat Server <<<<<<<<<<<<<<<<<<<<"
$TOMCAT_ROOT/bin/startup.sh

# UNCOMMENT this block lines to store war with comments
#COMMIT_ID=$(git log -1 --oneline | awk '{print $1;}')
#TODAY_DATE=$(date +%m%d%Y)
#echo ">>>>>>>>>> BackUp War Files with Commit <<<<<<<<<<<<<<<<<<<<"
#cp $TARGET_DIR/$WEBPROJECT_NAME.war $BACKUP_PATH/$TENANT_ID\_$TODAY_DATE\_$COMMIT_ID.war

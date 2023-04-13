for f in modules/P*; do
  file_name=`echo "$f" | tr '[:upper:]' '[:lower:]'`
  project_name=`echo $file_name | sed "s/modules\///"`
  echo ---------------------------------------------------------------------------------
  echo modules/$project_name:0.0.1-SNAPSHOT
  docker build $f/ -t modules/$project_name:0.0.1-SNAPSHOT
done



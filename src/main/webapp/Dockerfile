FROM google/appengine-java
# Install java8
run echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu precise main" | tee -a /etc/apt/sources.list
run echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu precise main" | tee -a /etc/apt/sources.list
run echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
run apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886
run apt-get update
run apt-get install -y oracle-java8-installer
#FROM foo
ADD . /home/vmagent/appengine-java-vmruntime/webapps/root

#FROM google/java-managed-vm




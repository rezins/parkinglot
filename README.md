## PARKING LOT INSTRUCTION

### Functional Suite
`functional_spec/` 

Berisi file aplikasi parking lot menggunakan java dengan build-tool gradle. Pada build gradle hanya menggunakan dependency untuk TTD menggunakan JUnit5, dan untuk file ``file_input.txt`` telah disimpan di dalam `resources` folder.

## Setup
### First 
- Install java atau open jdk 8 pada linux
    - ``$sudo apt-get install openjdk-8-jdk``
- Download gradle 6.7.1 dan pindahkan ke folder ``tmp``
    - ``$wget https://services.gradle.org/distributions/gradle-6.7.1-bin.zip -P /tmp``
- Unzip Gradle dan pindahkan ke folder ``opt``
    - ``$sudo unzip -d /opt/gradle /tmp/gradle-6.7.1-bin.zip``
- Create simbolic link dengan nama ``latest``
    - ``sudo ln -s /opt/gradle/gradle-6.7.1 /opt/gradle/latest``
- Setup environment variables
    - ``$sudo nano /etc/profile.d/gradle.sh``
- Isikan file ``/etc/profile.d/gradle.sh`` dengan script di bawah : 
    
    ````
  export GRADLE_HOME=/opt/gradle/latest
  export PATH=${GRADLE_HOME}/bin:${PATH}
- Simpan dan exit
- Eksekusi script di bawah untuk menjalankan gradle.sh
    - ``sudo chmod +x /etc/profile.d/gradle.sh``
- Load environment variable grale dengan menjalankan command di bawah 
    - ``source /etc/profile.d/gradle.sh``

### Second
- Salin folder ``parking_lot`` pada folder dalam linux
- Masuk ke folder ``parking_lot``
- Jalankan perintah ``bin/setup`` untuk menjalankan `gradle build` , `gradle test` , dan `Run Test Suit`
    - Jika terdapat error `bash: bin/setup : command not found` maka
        - jalankan ``sudo chmod +x bin/setup``
        - jalankan ``sudo chmod +x bin/parking_lot``
        - jalankan ``sudo chmod +x bin/run_functional_tests``
- Setelah Build Gradle selsai maka jalankan perintah `bin/run_functional_tests` , untuk melakukan functional test
- Jalankan `bin/parking_lot` untuk menjalankan program dengan interactive command, jalankan command `exit` untuk memberhentikan program
- Jalankan `bin/parking_lot file_inputs.txt` untuk menjalankan program dengan parameter `file_input.txt`

##### P.S : Berjalan dengan baik di OS Ubuntu 21.04
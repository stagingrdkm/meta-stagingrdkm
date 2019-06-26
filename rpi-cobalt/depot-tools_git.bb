SUMMARY = "Depot tools for Cobalt" 
HOMEPAGE = "https://cobalt.googlesource.com/"
BUGTRACKER = "https://cobalt.googlesource.com/"
SECTION = "console/network"
#TODO Check the license
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c2c05f9bdd5fc0b458037c2d1fb8d95e"

DEPENDS = "python-native"

SRC_URI = "git://cobalt.googlesource.com/depot_tools.git;protocol=https;rev=master"

SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""

S = "${WORKDIR}/git"

inherit autotools native

do_compile() {
}

do_install() {
    install -d ${D}${bindir} 
    install -d ${D}${bindir}/bootstrap 
    install -d ${D}${bindir}/bootstrap/virtualenv 
    install -d ${D}${bindir}/bootstrap/virtualenv/bin 
    install -d ${D}${bindir}/bootstrap/virtualenv/docs 
    install -d ${D}${bindir}/bootstrap/virtualenv/scripts 
    install -d ${D}${bindir}/bootstrap/virtualenv/tests 
    install -d ${D}${bindir}/bootstrap/virtualenv/virtualenv_embedded 
    install -d ${D}${bindir}/bootstrap/virtualenv/virtualenv_support 
    install -d ${D}${bindir}/bootstrap/win 
    install -d ${D}${bindir}/git-templates 
    install -d ${D}${bindir}/git-templates/hooks 
    install -d ${D}${bindir}/git-templates/info 
    install -d ${D}${bindir}/git_utils 
    install -d ${D}${bindir}/infra 
    install -d ${D}${bindir}/infra/config 
    install -d ${D}${bindir}/man 
    install -d ${D}${bindir}/man/html 
    install -d ${D}${bindir}/man/man1 
    install -d ${D}${bindir}/man/man7 
    install -d ${D}${bindir}/man/src 
    install -d ${D}${bindir}/recipes 
    install -d ${D}${bindir}/support 
    install -d ${D}${bindir}/testing_support 
    install -d ${D}${bindir}/tests 
    install -d ${D}${bindir}/tests/gstools 
    install -d ${D}${bindir}/tests/gstools/download_test_data 
    install -d ${D}${bindir}/tests/gstools/download_test_data/subfolder 
    install -d ${D}${bindir}/tests/subversion_config 
    install -d ${D}${bindir}/third_party 
    install -d ${D}${bindir}/third_party/boto 
    install -d ${D}${bindir}/third_party/boto/cacerts 
    install -d ${D}${bindir}/third_party/boto/contrib 
    install -d ${D}${bindir}/third_party/boto/core 
    install -d ${D}${bindir}/third_party/boto/datapipeline 
    install -d ${D}${bindir}/third_party/boto/ecs 
    install -d ${D}${bindir}/third_party/boto/file 
    install -d ${D}${bindir}/third_party/boto/fps 
    install -d ${D}${bindir}/third_party/boto/gs 
    install -d ${D}${bindir}/third_party/boto/manage 
    install -d ${D}${bindir}/third_party/boto/mashups
    install -d ${D}${bindir}/third_party/boto/pyami 
    install -d ${D}${bindir}/third_party/boto/roboto 
    install -d ${D}${bindir}/third_party/boto/s3 
    install -d ${D}${bindir}/third_party/boto/services 
    install -d ${D}${bindir}/third_party/boto/ses 
    install -d ${D}${bindir}/third_party/boto/sts 
    install -d ${D}${bindir}/third_party/colorama 
    install -d ${D}${bindir}/third_party/coverage 
    install -d ${D}${bindir}/third_party/coverage/fullcoverage 
    install -d ${D}${bindir}/third_party/coverage/htmlfiles 
    install -d ${D}${bindir}/third_party/cq_client 
    install -d ${D}${bindir}/third_party/cq_client/test 
    install -d ${D}${bindir}/third_party/fancy_urllib 
    install -d ${D}${bindir}/third_party/gsutil 
    install -d ${D}${bindir}/third_party/gsutil/gslib 
    install -d ${D}${bindir}/third_party/gsutil/gslib/addlhelp 
    install -d ${D}${bindir}/third_party/gsutil/gslib/commands 
    install -d ${D}${bindir}/third_party/gsutil/oauth2_plugin 
    install -d ${D}${bindir}/third_party/gsutil/plugins 
    install -d ${D}${bindir}/third_party/httplib2 
    install -d ${D}${bindir}/third_party/logilab 
    install -d ${D}${bindir}/third_party/logilab/astroid 
    install -d ${D}${bindir}/third_party/logilab/astroid/brain 
    install -d ${D}${bindir}/third_party/logilab/common 
    install -d ${D}${bindir}/third_party/logilab/common/ureports 
    install -d ${D}${bindir}/third_party/oauth2client 
    install -d ${D}${bindir}/third_party/protobuf26 
    install -d ${D}${bindir}/third_party/protobuf26/compiler 
    install -d ${D}${bindir}/third_party/protobuf26/internal 
    install -d ${D}${bindir}/third_party/pylint 
    install -d ${D}${bindir}/third_party/pylint/checkers 
    install -d ${D}${bindir}/third_party/pylint/pyreverse 
    install -d ${D}${bindir}/third_party/pylint/reporters 
    install -d ${D}${bindir}/third_party/pymox 
    install -d ${D}${bindir}/third_party/repo 
    install -d ${D}${bindir}/third_party/retry_decorator 
    install -d ${D}${bindir}/third_party/simplejson 
    install -d ${D}${bindir}/third_party/six 
    install -d ${D}${bindir}/win_toolchain 
    install -d ${D}${bindir}/win_toolchain/7z 
    install -d ${D}${bindir}/zsh-goodies 
    find ${S}                                            -maxdepth 1 -type f -exec install {} ${D}${bindir} \;
    find ${S}                                            -maxdepth 1 -type l -exec install {} ${D}${bindir} \;
    find ${S}/bootstrap                                  -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap \;
    find ${S}/bootstrap/virtualenv                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv \;
    find ${S}/bootstrap/virtualenv/bin                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/bin \;
    find ${S}/bootstrap/virtualenv/docs                  -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/docs \;
    find ${S}/bootstrap/virtualenv/scripts               -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/scripts \;
    find ${S}/bootstrap/virtualenv/tests                 -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/tests \;
    find ${S}/bootstrap/virtualenv/virtualenv_embedded   -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/virtualenv_embedded \;
    find ${S}/bootstrap/virtualenv/virtualenv_support    -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/virtualenv/virtualenv_support \;
    find ${S}/bootstrap/win                              -maxdepth 1 -type f -exec install {} ${D}${bindir}/bootstrap/win \;
    find ${S}/git-templates                              -maxdepth 1 -type f -exec install {} ${D}${bindir}/git-templates \;
    find ${S}/git-templates/hooks                        -maxdepth 1 -type f -exec install {} ${D}${bindir}/git-templates/hooks \;
    find ${S}/git-templates/info                         -maxdepth 1 -type f -exec install {} ${D}${bindir}/git-templates/info \;
    find ${S}/git_utils                                  -maxdepth 1 -type f -exec install {} ${D}${bindir}/git_utils \;
    find ${S}/infra                                      -maxdepth 1 -type f -exec install {} ${D}${bindir}/infra \;
    find ${S}/infra/config                               -maxdepth 1 -type f -exec install {} ${D}${bindir}/infra/config \;
    find ${S}/man                                        -maxdepth 1 -type f -exec install {} ${D}${bindir}/man \;
    find ${S}/man/html                                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/man/html \;
    find ${S}/man/man1                                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/man/man1 \;
    find ${S}/man/man7                                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/man/man7 \;
    find ${S}/man/src                                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/man/src \;
    find ${S}/recipes                                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/recipes \;
    find ${S}/support                                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/support \;
    find ${S}/testing_support                            -maxdepth 1 -type f -exec install {} ${D}${bindir}/testing_support \;
    find ${S}/tests                                      -maxdepth 1 -type f -exec install {} ${D}${bindir}/tests \;
    find ${S}/tests/gstools                              -maxdepth 1 -type f -exec install {} ${D}${bindir}/tests/gstools \;
    find ${S}/tests/gstools/download_test_data           -maxdepth 1 -type f -exec install {} ${D}${bindir}/tests/gstools/download_test_data \;
    find ${S}/tests/gstools/download_test_data/subfolder -maxdepth 1 -type f -exec install {} ${D}${bindir}/tests/gstools/download_test_data/subfolder \;
    find ${S}/tests/subversion_config                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/tests/subversion_config \;
    find ${S}/third_party                                -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party \;
    find ${S}/third_party/boto                           -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto \;
    find ${S}/third_party/boto/cacerts                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/cacerts \;
    find ${S}/third_party/boto/contrib                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/contrib \;
    find ${S}/third_party/boto/core                      -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/core \;
    find ${S}/third_party/boto/datapipeline              -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/datapipeline \;
    find ${S}/third_party/boto/ecs                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/ecs \;
    find ${S}/third_party/boto/file                      -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/file \;
    find ${S}/third_party/boto/fps                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/fps \;
    find ${S}/third_party/boto/gs                        -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/gs \;
    find ${S}/third_party/boto/manage                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/manage \;
    find ${S}/third_party/boto/mashups                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/mashups \;
    find ${S}/third_party/boto/pyami                     -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/pyami \;
    find ${S}/third_party/boto/roboto                    -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/roboto \;
    find ${S}/third_party/boto/s3                        -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/s3 \;
    find ${S}/third_party/boto/services                  -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/services \;
    find ${S}/third_party/boto/ses                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/ses \;
    find ${S}/third_party/boto/sts                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/boto/sts \;
    find ${S}/third_party/colorama                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/colorama \;
    find ${S}/third_party/coverage                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/coverage \;
    find ${S}/third_party/coverage/fullcoverage          -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/coverage/fullcoverage \;
    find ${S}/third_party/coverage/htmlfiles             -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/coverage/htmlfiles \;
    find ${S}/third_party/cq_client                      -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/cq_client \;
    find ${S}/third_party/cq_client/test                 -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/cq_client/test \;
    find ${S}/third_party/fancy_urllib                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/fancy_urllib \;
    find ${S}/third_party/gsutil                         -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil \;
    find ${S}/third_party/gsutil/gslib                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil/gslib \;
    find ${S}/third_party/gsutil/gslib/addlhelp          -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil/gslib/addlhelp \;
    find ${S}/third_party/gsutil/gslib/commands          -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil/gslib/commands \;
    find ${S}/third_party/gsutil/oauth2_plugin           -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil/oauth2_plugin \;
    find ${S}/third_party/gsutil/plugins                 -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/gsutil/plugins \;
    find ${S}/third_party/httplib2                       -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/httplib2 \;
    find ${S}/third_party/logilab                        -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/logilab \;
    find ${S}/third_party/logilab/astroid                -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/logilab/astroid \;
    find ${S}/third_party/logilab/astroid/brain          -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/logilab/astroid/brain \;
    find ${S}/third_party/logilab/common                 -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/logilab/common \;
    find ${S}/third_party/logilab/common/ureports        -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/logilab/common/ureports \;
    find ${S}/third_party/oauth2client                   -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/oauth2client \;
    find ${S}/third_party/protobuf26                     -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/protobuf26 \;
    find ${S}/third_party/protobuf26/compiler            -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/protobuf26/compiler \;
    find ${S}/third_party/protobuf26/internal            -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/protobuf26/internal \;
    find ${S}/third_party/pylint                         -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/pylint \;
    find ${S}/third_party/pylint/checkers                -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/pylint/checkers \;
    find ${S}/third_party/pylint/pyreverse               -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/pylint/pyreverse \;
    find ${S}/third_party/pylint/reporters               -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/pylint/reporters \;
    find ${S}/third_party/pymox                          -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/pymox \;
    find ${S}/third_party/repo                           -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/repo \;
    find ${S}/third_party/retry_decorator                -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/retry_decorator \;
    find ${S}/third_party/simplejson                     -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/simplejson \;
    find ${S}/third_party/six                            -maxdepth 1 -type f -exec install {} ${D}${bindir}/third_party/six \;
    find ${S}/win_toolchain                              -maxdepth 1 -type f -exec install {} ${D}${bindir}/win_toolchain \;
    find ${S}/win_toolchain/7z                           -maxdepth 1 -type f -exec install {} ${D}${bindir}/win_toolchain/7z \;
    find ${S}/zsh-goodies                                -maxdepth 1 -type f -exec install {} ${D}${bindir}/zsh-goodies \;
    rm -f ${D}${bindir}/ninja
}


BBCLASSEXTEND = "native nativesdk"

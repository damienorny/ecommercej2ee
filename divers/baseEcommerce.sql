-- phpMyAdmin SQL Dump
-- version 4.3.12
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 31 Mars 2015 à 17:26
-- Version du serveur :  10.0.17-MariaDB-log
-- Version de PHP :  5.6.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ecommercej2ee`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int(11) NOT NULL,
  `nom_article` varchar(255) NOT NULL,
  `desc_article` text NOT NULL,
  `prix_article` float NOT NULL,
  `src_article` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`id_article`, `nom_article`, `desc_article`, `prix_article`, `src_article`) VALUES
(3, 'Mad Catz C.Y.B.O.R.G. V5 (Cyborg V5)', '<p><br> </p>  <p><strong>Performances de jeu 24h/24</strong><br> <br> En plein jour ou dans la pénombre, vos performances de jeu seront toujours au top avec le clavier de gaming&nbsp;<strong>Mad Catz V.5</strong>&nbsp;! Grâce à&nbsp;ses touches rétro-éclairées transparentes vous trouverez toujours la bonne touche lors des parties nocturnes.<br> <br> <strong>Une parfaite lisibilité, même dans la pénombre</strong><br> Le rétro-éclairage s’illumine à travers les touches découpées au laser en&nbsp;"rouge furtif" pour que vous obteniez la meilleure vision de nuit possible.<br> <br> <strong>Jouez sans contraintes techniques</strong><br> La fonction&nbsp;"Anti-Ghosting" des zones de jeu principales garantit que les touches frappées simultanément répondent correctement.<br> <br> <strong>Caractéristiques principales :</strong></p>  <ul>     <li><strong>Rétro-éclairage</strong>&nbsp;performant à travers des&nbsp;<strong>touches découpées au laser</strong></li>      <li>Fonction&nbsp;<strong>"Anti-Ghosting"&nbsp;</strong>: pression simultanée de plusieurs touches sans blocage</li>      <li>Touches multimédias (<em>y compris&nbsp;contrôle du son</em>)</li>      <li>Programmation de touches de fonction avec macros de jeu, via logiciel ST</li>      <li><strong>Repose-poignet&nbsp;</strong>intégré, pour un confort de jeu optimisé</li>      <li>Interface USB 2.0</li>      <li>Compatible Windows XP / Vista / 7</li> </ul>  <p><br> </p>', 49.9, 'http://media.ldlc.com/ld/products/00/01/23/24/LD0001232431_2.jpg'),
(4, 'Alienware modèle M17X', 'Alienware modèle M17X\n\n<p><span style="font-size: 24px; line-height: 1.1;">Configuration:</span></p>\n\n<ul>  \n  <li>Marque&nbsp;: DELL (Alienware)</li>\n  \n  <li>Modèle&nbsp;: M17x R5</li>\n  \n  <li>Processeur&nbsp;: Intel® Core™ i7-4800MQ</li>\n  \n  <li>Mémoire&nbsp;: 16GB onboard memory (DDR3L-1600MHz)</li>\n  \n  <li>Carte graphique&nbsp;: NVIDIA® GeForce® GTX 780M (4GB GDDR5 VRAM, Optimus™ Technology) et Chipset graphique: Intel® HD4600</li>\n  \n  <li>Écran&nbsp;(Taille, Type, Résolution) : 17.0″ mat 1920*1080, avec LED backlight</li>\n  \n  <li>Stockage&nbsp;: Msata 256GO / SSD Crucial M4 512go SATA III / &nbsp;HDD 1TO 5400tr SATA II</li>\n  \n  <li>Optique&nbsp;: Lecteur blueray / graveur DVD</li>\n  \n  <li>Ethernet&nbsp;: KILLER E2200</li>\n  \n  <li>WiFi / Bluetooth&nbsp;:&nbsp;BROADCOM (802.11a/b/g/n + Bluetooth® 4.0)</li>\n  \n  <li>USB / Firewire&nbsp;: USB 3.0 port x4 (SuperSpeed)</li>\n  \n  <li>SPDIF / Casque / Micro&nbsp;: 3.5mm * 3</li>\n  \n  <li>Sortie vidéo&nbsp;: HDMI 1.4a audio and video / DP</li>\n  \n  <li>Entrée vidéo&nbsp;:&nbsp;HDMI 1.4a audio and video</li>\n  \n  <li>Poids&nbsp;: 4.15kg</li>\n</ul>', 1299, 'http://www.notebookcheck.biz/uploads/tx_nbc2/awareM17X.jpg'),
(5, 'Renault Zoé', '<p></p>\n\n<p>  </p>\n\n<h2>Caractéristiques techniques de la ZOE</h2>\n\n<p>      </p>\n\n<h3>Dimensions</h3>\n\n<p>      </p>\n\n<table>        \n  <tbody>          \n    <tr>            \n      <th>Longueur (mm)</th>\n            \n      <td>4 084</td>\n          </tr>\n          \n    <tr>            \n      <th>Largeur hors tout (mm)</th>\n            \n      <td>1 730</td>\n          </tr>\n          \n    <tr>            \n      <th>Hauteur à vide (mm)</th>\n            \n      <td>1 568</td>\n          </tr>\n          \n    <tr>            \n      <th>Empattement (mm)</th>\n            \n      <td>2 588</td>\n          </tr>\n          \n    <tr>            \n      <th>Volume de coffre (L)</th>\n            \n      <td>338</td>\n          </tr>\n          \n    <tr>            \n      <th>Nombre de places</th>\n            \n      <td>5</td>\n          </tr>\n          \n    <tr>            \n      <th>Porte-à-faux avant / arrière&nbsp;(mm)</th>\n            \n      <td>836 / 661</td>\n          </tr>\n          \n    <tr>            \n      <th>Voies avant / arrière (mm)</th>\n            \n      <td>1 506 / 1 489</td>\n          </tr>\n        </tbody>\n      </table>\n\n<p>      </p>\n\n<h3>Moteur</h3>\n\n<p>      </p>\n\n<table>        \n  <tbody>          \n    <tr>            \n      <th>Type</th>\n            \n      <td>Synchrone à rotor bobiné</td>\n          </tr>\n          \n    <tr>            \n      <th>Puissance (kW) / (ch)</th>\n            \n      <td>65 / 88</td>\n          </tr>\n          \n    <tr>            \n      <th>Couple max (Nm)</th>\n            \n      <td>220</td>\n          </tr>\n          \n    <tr>            \n      <th>Transmission</th>\n            \n      <td>Réducteur</td>\n          </tr>\n        </tbody>\n      </table>\n\n<p>      </p>\n\n<h3>Batterie</h3>\n\n<p>      </p>\n\n<table>        \n  <tbody>          \n    <tr>            \n      <th>Type</th>\n            \n      <td><a href="http://www.automobile-propre.com/tag/lithium/">Lithium</a>-ion</td>\n          </tr>\n          \n    <tr>            \n      <th>Capacité (kWh)</th>\n            \n      <td>22</td>\n          </tr>\n          \n    <tr>            \n      <th>Autonomie (NEDC)</th>\n            \n      <td>210 km</td>\n          </tr>\n          \n    <tr>            \n      <th><a href="http://www.automobile-propre.com/tag/vitesse/">Vitesse</a>&nbsp;max (km/h)</th>\n            \n      <td>135</td>\n          </tr>\n        </tbody>\n      </table>\n\n<p>      </p>\n\n<h3>Chargeur</h3>\n\n<p>      </p>\n\n<table>        \n  <tbody>          \n    <tr>            \n      <th>Type</th>\n            \n      <td>Mono-triphasé jusqu’à 43 kW</td>\n          </tr>\n          \n    <tr>            \n      <th>Temps de recharge</th>\n            \n      <td>              \n        <ul>                \n          <li>3 kW (wall box monophasée 16 A) =&nbsp;9 h</li>\n                \n          <li>22 kW (borne triphasée 32 A) = 1h</li>\n                \n          <li>43 kW (borne triphasée 63 A) = 30&nbsp;minutes</li>\n              </ul>\n            </td>\n          </tr>\n        </tbody>\n      </table>\n\n<p><br>\n</p>\n\n<p><br>\n</p>', 19000, 'http://www.avem.fr/img/vep/zoe_ze.jpg'),
(6, 'Logitech G502', '<p style="text-align: left;">Superbe souris sans fil :&nbsp;</p>\n\n<ul>\n  <li>Fil&nbsp;d''<strong>un&nbsp;mètre</strong></li>\n\n  <li>Laser&nbsp;rouge</li>\n\n  <li>Haute&nbsp;définition&nbsp;<strong>300dpi</strong></li>\n\n  <li><strong>USB&nbsp;3.0&nbsp;</strong>pour&nbsp;plus&nbsp;de&nbsp;rapidité</li>\n\n  <li><strong>4&nbsp;boutons</strong>&nbsp;paramétrables&nbsp;avec&nbsp;des&nbsp;macros</li>\n\n  <li>Molette&nbsp;à&nbsp;<strong>4&nbsp;directions</strong></li>\n</ul>\n\n<p>Garantie 2 ans après la date d''achat. Fournie avec manuel explicatif et un CD-ROM pour les pilotes</p>', 60, 'http://ecx.images-amazon.com/images/I/511jsM-qGkL.jpg'),
(7, 'Sony Xperia Z3 Compact', '<p><br>\r\n</p>\r\n\r\n<table>  \r\n  <thead>    \r\n    <tr>      \r\n      <th colspan="2">        \r\n        <h3>CARACTÉRISTIQUES TECHNIQUES :&nbsp;SONY - XPERIA Z3 COMPACT BLANC</h3>\r\n      </th>\r\n    </tr>\r\n  </thead>\r\n  \r\n  <tbody>    \r\n    <tr>      \r\n      <td colspan="2">Général</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Système d''Exploitation</td>\r\n      \r\n      <td>Android 4.4 KitKat</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Type de Processeur</td>\r\n      \r\n      <td>Qualcomm MSM8974AC Snapdragon 801</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Nombre de Cœurs</td>\r\n      \r\n      <td>Quadri-Cœur</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Vitesse du Processeur</td>\r\n      \r\n      <td>2,5 GHz</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Couleur</td>\r\n      \r\n      <td>Blanc</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Dimensions (h/l/e)</td>\r\n      \r\n      <td>127 x 64,9 x 8,6 mm</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Poids</td>\r\n      \r\n      <td>129 g</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Débit d''Absorption Spécifique</td>\r\n      \r\n      <td>NC</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Type de SIM</td>\r\n      \r\n      <td>Nano-SIM</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Affichage et Résolution</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Taille de l''Ecran Principal</td>\r\n      \r\n      <td>4,6"</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Type d''Ecran Principal</td>\r\n      \r\n      <td>Tactile TRILUMINOS™ pour mobile avec le moteur d''image X-Reality™</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Résolution</td>\r\n      \r\n      <td>HD (720x1280 pixels)</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Couleur de l''Ecran Compatible</td>\r\n      \r\n      <td>16,7 Millions de Couleurs</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Mémoire</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Mémoire Intégrée (ROM)</td>\r\n      \r\n      <td>16 Go</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Mémoire Vive (RAM)</td>\r\n      \r\n      <td>2 Go</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Emplacement de Carte Mémoire</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Carte Mémoire Compatible</td>\r\n      \r\n      <td>MicroSD (prise en charge SDXC)</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Taille Maximale pris en charge</td>\r\n      \r\n      <td>128 Go</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Caractéristiques de la Batterie</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Batterie</td>\r\n      \r\n      <td>2600 mAh Li-Ion</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Autonomie en Conversation</td>\r\n      \r\n      <td>Jusqu''à 14 heures</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Autonomie en Veille</td>\r\n      \r\n      <td>Jusqu''à 920 heures</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Image</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Appareil Photo</td>\r\n      \r\n      <td>20,7 Mpixels avec le capteur d''images Exmor RS® pour mobile de Sony, HDR, Sweep Panorama, taille du capteur : 1/2.3'''', Géolocalisation, SteadyShot™, Mode Rafale, suivi d''objet, Réduction des yeux rouges - Zoom numérique 8x</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Appareil Photo Frontal</td>\r\n      \r\n      <td>2,2 Mpixels</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Flash</td>\r\n      \r\n      <td>LED pulsée</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Autofocus</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Résolution Maximale de l''Image</td>\r\n      \r\n      <td>5248 x 3936 pixels</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Vidéo</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Enregistrement Vidéo</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Résolution Maximale Vidéo</td>\r\n      \r\n      <td>4K 2160p en 30 img/s ou Full HD 1080p en 60 img/s</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Formats d''Enregistrement</td>\r\n      \r\n      <td>3GPP, MP4</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Audio</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Radio</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Type de Tuner Radio</td>\r\n      \r\n      <td>FM avec RDS</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Formats Audio</td>\r\n      \r\n      <td>3GPP, MP4, ADTS, AMR, DSF, DSDIFF, FLAC, Matroska, SMF, XMF, Mobile XMF, OTA, RTTTL, RTX, iMelody, MP3, WAV, OGG, ASF</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td colspan="2">Réseau et Communication</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Bande Réseau</td>\r\n      \r\n      <td>Quadri-Bande</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>GPRS</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>EDGE</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>HSDPA (3G+)</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>UMTS (3G)</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>4G</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Wi-Fi</td>\r\n      \r\n      <td>Oui</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>Bluetooth</td>\r\n      \r\n      <td>4.0 A2DP et Low Energy (LE)</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>USB</td>\r\n      \r\n      <td>2.0 (MHL) On-the-go</td>\r\n    </tr>\r\n    \r\n    <tr>      \r\n      <td>GPS Intégré</td>\r\n      \r\n      <td>\r\n        <p>GPS avec A-GPS &amp; GLONASS</p>\r\n      </td>\r\n    </tr>\r\n  </tbody>\r\n</table>\r\n\r\n<p><br>\r\n</p>', 409.9, 'http://api.sonymobile.com/files/xperia-z3-compact-black-1240x840-2f1d546fc795ff2d1295547982a23cb4.jpg'),
(8, 'BESTÅ BURS', '<p><br>\r\n</p>\r\n\r\n<p>  Bon à savoir  Mesurer toujours la profondeur et la largeur de votre téléviseur. Les dimensions doivent être inférieures à celle du meuble TV.</p>\r\n\r\n<p>Peut être complété par les aménagements intérieurs INREDA.</p>\r\n\r\n<p>Poignées incluses.</p>\r\n\r\n<p><br>\r\n</p>\r\n\r\n<p>  Conseil d''entretien  Nettoyer avec un chiffon imbibé d''un détergent doux.</p>\r\n\r\n<p>Terminer en essuyant avec un chiffon sec.</p>\r\n\r\n<p><br>\r\n</p>\r\n\r\n<p>  Description du produit  Composants principaux/ Face de tiroir: Panneau de particules, Feuille décor, Feuille de mélamine</p>\r\n\r\n<p>Plateau supérieur: Panneau de particules, Panneau de particules, Feuille décor, Feuille de mélamine, Carton nid d''abeille recyclé, Feuille décor</p>\r\n\r\n<p>Cloison/ Etagère/ Plateau inférieur: Panneau de particules, Feuille de mélamine, plastique ABS</p>\r\n\r\n<p>Dos: Panneau de fibres de bois</p>\r\n\r\n<p>Arrière de tiroir/ Côté de tiroir: Panneau de particules, Feuille décor</p>\r\n\r\n<p>Fond de tiroir: Panneau de fibres de bois, peinture acrylique, peinture acrylique</p>\r\n\r\n<p>Pied: plastique ABS</p>\r\n\r\n<p>Composants principaux: aluminium</p>\r\n\r\n<p><br>\r\n</p>', 249, 'http://www.ikea.com/fr/fr/images/products/besta-burs-banc-tv-gris__0103386_PE249425_S4.JPG');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id_category` int(11) NOT NULL,
  `nom_category` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`id_category`, `nom_category`) VALUES
(4, 'Informatique'),
(5, 'Materiel'),
(6, 'Voiture'),
(7, 'Portable'),
(8, 'Meuble');

-- --------------------------------------------------------

--
-- Structure de la table `category_article`
--

CREATE TABLE IF NOT EXISTS `category_article` (
  `id_category` int(11) NOT NULL,
  `id_article` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `category_article`
--

INSERT INTO `category_article` (`id_category`, `id_article`) VALUES
(4, 3),
(4, 4),
(4, 6),
(7, 4),
(7, 7),
(8, 8);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `mdp_client` varchar(255) NOT NULL,
  `adresse_client` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `email_client`, `mdp_client`, `adresse_client`) VALUES
(15, 'Orny', 'Damien', 'damien.orny@edu.esiee.fr', 'azerty', 'Noisy-Champs, 77420');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL,
  `date_commande` varchar(255) NOT NULL,
  `prix_commande` float NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `date_commande`, `prix_commande`, `id_client`) VALUES
(21, 'Tue Mar 31 17:14:57 CEST 2015', 869.7, 15);

-- --------------------------------------------------------

--
-- Structure de la table `commande_article`
--

CREATE TABLE IF NOT EXISTS `commande_article` (
  `id_commande` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande_article`
--

INSERT INTO `commande_article` (`id_commande`, `id_article`, `quantite`) VALUES
(21, 3, 1),
(21, 7, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Index pour la table `category_article`
--
ALTER TABLE `category_article`
  ADD PRIMARY KEY (`id_category`,`id_article`), ADD KEY `id_article` (`id_article`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`), ADD UNIQUE KEY `email_client` (`email_client`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`), ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `commande_article`
--
ALTER TABLE `commande_article`
  ADD PRIMARY KEY (`id_commande`,`id_article`), ADD KEY `id_article` (`id_article`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `category_article`
--
ALTER TABLE `category_article`
ADD CONSTRAINT `category_article_ibfk_1` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`),
ADD CONSTRAINT `category_article_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `commande_article`
--
ALTER TABLE `commande_article`
ADD CONSTRAINT `commande_article_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
ADD CONSTRAINT `commande_article_ibfk_2` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

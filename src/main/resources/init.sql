-- 管理员表
CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 游戏信息表
CREATE TABLE IF NOT EXISTS game_info (
    id INT PRIMARY KEY AUTO_INCREMENT,
    game_name VARCHAR(100) NOT NULL,
    slogan VARCHAR(200),
    background CLOB,
    gameplay CLOB,
    operation CLOB,
    feature CLOB,
    download_url VARCHAR(500),
    play_url VARCHAR(500),
    install_note CLOB,
    faq CLOB,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 角色表
CREATE TABLE IF NOT EXISTS character (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    avatar VARCHAR(500),
    intro VARCHAR(500),
    advantage VARCHAR(200),
    disadvantage VARCHAR(200),
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 技能表
CREATE TABLE IF NOT EXISTS skill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    character_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    icon VARCHAR(500),
    description VARCHAR(500) NOT NULL,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 玩家排行榜表
CREATE TABLE IF NOT EXISTS player_rank (
    id INT PRIMARY KEY AUTO_INCREMENT,
    player_name VARCHAR(50) NOT NULL,
    score INT NOT NULL,
    play_time INT,
    message VARCHAR(200),
    message_status INT DEFAULT 0,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 公告表
CREATE TABLE IF NOT EXISTS notice (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    category VARCHAR(50) NOT NULL,
    content CLOB NOT NULL,
    is_top INT DEFAULT 0,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 插入数据 (使用INSERT IGNORE或先删除再插入)
DELETE FROM admin WHERE id = 1;
INSERT INTO admin (id, username, password) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

DELETE FROM game_info WHERE id = 1;
INSERT INTO game_info (id, game_name, slogan, background, gameplay, operation, feature, download_url, play_url, install_note, faq) VALUES
(1, 'Verse Brawl', '跨次元，来乱斗',
'在像素世界中，玩家操控角色展开实时对战，击败对手获得分数，登顶排行榜',
'1. 选择角色 2. 匹配对手 3. 释放技能 4. 击败对手 5. 获得分数',
'WASD 移动、空格跳跃、鼠标点击释放技能',
'轻量化体积、流畅对战、多种角色可选、技能组合丰富、排行榜实时更新',
'https://github.com/example/verse-brawl/releases',
null,
'最低配置: Windows 10、4GB内存、独立显卡',
'无法打开游戏: 请检查是否安装了最新版.NET框架');

DELETE FROM character WHERE id IN (1,2,3,4);
INSERT INTO character (id, name, avatar, intro, advantage, disadvantage) VALUES
(1, '战士', '/images/character/warrior.png', '高血量、高攻击，适合正面交锋', '血量高、攻击强', '移动速度较慢'),
(2, '法师', '/images/character/mage.png', '远程魔法攻击，擅长控制和输出', '远程攻击、技能范围大', '血量较低'),
(3, '刺客', '/images/character/assassin.png', '高机动性，擅长快速切入和爆发', '移动速度快、爆发高', '防御较弱'),
(4, '弓手', '/images/character/archer.png', '远程物理攻击，精准打击', '攻击距离远、精准度高', '近战能力弱');

DELETE FROM skill WHERE id BETWEEN 1 AND 16;
INSERT INTO skill (id, character_id, name, icon, description) VALUES
(1, 1, '冲锋', '/images/skill/charge.png', '向前冲刺并撞击敌人，造成50伤害'),
(2, 1, '格挡', '/images/skill/block.png', '举起盾牌格挡攻击，持续3秒'),
(3, 1, '重击', '/images/skill/heavy.png', '蓄力后发动强力攻击，造成80伤害'),
(4, 1, '战吼', '/images/skill/roar.png', '发出战吼提升自身攻击力10%'),
(5, 2, '火球', '/images/skill/fireball.png', '发射火球攻击敌人，造成40伤害'),
(6, 2, '冰冻', '/images/skill/freeze.png', '冻结敌人，使其无法移动2秒'),
(7, 2, '闪电', '/images/skill/lightning.png', '召唤闪电链攻击多个敌人'),
(8, 2, '传送', '/images/skill/teleport.png', '瞬间传送到指定位置'),
(9, 3, '隐身', '/images/skill/invisible.png', '进入隐身状态，持续5秒'),
(10, 3, '瞬斩', '/images/skill/flash.png', '瞬间闪现到敌人身后发动攻击'),
(11, 3, '毒刃', '/images/skill/poison.png', '附加毒素，持续伤害5秒'),
(12, 3, '影步', '/images/skill/shadow.png', '留下残影，快速移动到新位置'),
(13, 4, '穿透箭', '/images/skill/pierce.png', '射出穿透箭矢，可击中多个敌人'),
(14, 4, '连射', '/images/skill/multi.png', '连续射出三支箭矢'),
(15, 4, '陷阱', '/images/skill/trap.png', '放置陷阱，触发后束缚敌人'),
(16, 4, '鹰眼', '/images/skill/hawk.png', '开启鹰眼，提升攻击范围');

DELETE FROM player_rank WHERE id BETWEEN 1 AND 6;
INSERT INTO player_rank (id, player_name, score, play_time, message, message_status) VALUES
(1, 'PixelKnight', 9500, 120, '最强的战士！', 1),
(2, 'ShadowMaster', 8800, 95, '刺客之王', 1),
(3, 'FireMage', 8500, 80, '火焰吞噬一切', 1),
(4, 'ArrowStorm', 7200, 60, null, 0),
(5, 'GameLover', 6500, 45, '新人加油！', 1),
(6, 'ProPlayer', 5800, 30, null, 0);

DELETE FROM notice WHERE id BETWEEN 1 AND 3;
INSERT INTO notice (id, title, category, content, is_top) VALUES
(1, 'Verse Brawl v1.0 正式发布！', '版本更新', '经过长时间的开发，Verse Brawl 终于正式发布！新增4个角色：战士、法师、刺客、弓手', 1),
(2, '新春活动开启', '活动通知', '春节期间登录游戏可获得限定角色皮肤！', 0),
(3, '服务器维护通知', '维护公告', '计划于2026年1月20日凌晨2:00-4:00进行服务器维护。', 0);